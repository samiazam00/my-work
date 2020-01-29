example : ∀ P Q R : Prop, (P → Q) → (P ∧ R) → (Q ∧ (1 = 1)) :=
begin
    assume P Q R,
    assume pq,
    assume pr,
    apply and.intro _ _,
        -- solving for hole 1, proof of Q
        exact pq (and.elim_left pr),
        -- solving for hole 2, proof of 1 = 1
        exact eq.refl 1,
end
/- The above proof tests:
- and (intro/elim)
- equality
- solving foralls (assume the Props, which we did on the first line)
- solving proofs with implications (assume the premise(s), which we did on line 2 and 3)
- using implications, or functions, in proofs (we did this on the fifth line, when we supplied a proof of P to "pq")
-/

def false_elim (P : Prop): false -> P :=
begin
assume pfFalse,
apply false.elim pfFalse,
end
def and_intro (P Q : Prop) : P -> Q -> (P ∧ Q) :=
begin
assume pfP,
assume pfQ,
apply and.intro pfP pfQ,
end
def and_elim_left (P Q : Prop): (P ∧ Q) -> P :=
begin
assume pnq,
apply and.elim_left pnq,
end
def and_elim_right (P Q : Prop) : (P ∧ Q) -> Q :=
begin
assume pnq,
apply and.elim_right pnq,
end
def or_intro_left (P Q : Prop): P -> (P ∨ Q) :=
begin
assume pfP,
--or.intro_left _ _
--apply or.intro_left Q pfP, --FORMAL
apply or.inl pfP, --SHORTHAND
end
def or_intro_right (P Q : Prop): Q -> (P ∨ Q) :=
begin
assume pfQ,
--apply or.intro_right P pfQ, --FORMAL
apply or.inr pfQ, --SHORTHAND
end
def or_elim (P Q R : Prop) : (P ∨ Q) -> (P -> R) -> (Q -> R) -> R :=
begin
assume porq pimpr qimpr,
cases porq with pfP pfQ,
exact pimpr pfP,
exact qimpr pfQ,
end

def arrow_elim (P Q : Prop): (P -> Q) -> P -> Q :=
begin
assume pimpq pfP,
exact pimpq pfP,
end
def syllogism (P Q R : Prop): (P -> Q) -> (Q -> R) -> (P -> R) :=
begin
assume pimpq qimpr pfP,
have pfQ : Q := pimpq pfP,
have pfR : R := qimpr pfQ,
exact pfR,
end
def syllogism' (P Q R : Prop): (P -> Q) -> (Q -> R) -> (P -> R) :=
begin
intros,
apply a_1,
apply a,
exact a_2,
end
def syllogism'' (P Q R : Prop): (P -> Q) -> (Q -> R) -> (P -> R) :=
begin
assume pimpq qimpr pfP,
exact qimpr (pimpq pfP),
end
--All three of the above proofs are valid proofs and would get full
--credit on the exam
def modus_tollens (P Q : Prop): (P -> Q) -> ¬ Q -> ¬ P :=
begin
assume pimpq nq,
-- (¬P) is equivalent to (P → false)
assume pfP,
have pfQ : Q := pimpq pfP,
contradiction, -- ¬Q is the same as (Q → false). We have a proof
--of Q, so we can get to the proof of false.
end
def neg_intro (P : Prop): (P -> false) -> ¬ P :=
begin
intros, --intros will NOT catch ¬ P being the same as P → false
assume pfP,
exact a pfP, --contradiction works, since P → false is the same
--as ¬P
end
def neg_intro' (P : Prop): (P -> false) -> ¬ P :=
begin
intros,
exact a,
end
example : 1=1 :=
begin
apply eq.refl 1,
end
example : 3+5 = 8 :=
begin
apply eq.refl 8,
end
example : 2+3 = 5 ∧ 3+7 = 10 → 2+5 = 7 :=
begin
intros premise,
apply eq.refl 7,
end
example : 0 = 1 → 3 = 1000 :=
begin
assume zeroeqone,
have zeroneqone : 0 ≠ 1 := dec_trivial,
contradiction,
end

def resolution (P Q R: Prop): (P ∨ Q) -> ((¬ Q ∨ R) -> (P ∨ R)) :=
begin
assume porq nqorr,
cases porq with pfP pfQ,
--apply or.intro_left R pfP
apply or.inl pfP, --solved case 1: P is true
--Now, we need to solve the case where Q is true
cases nqorr with nq pfR,
contradiction, --solves case of ¬Q being true
apply or.intro_right P pfR, --solves case of R being true

end
/-
TRUTH TABLE FOR RESOLUTION
P | Q | R | ¬ Q | P ∨ Q | ¬ Q ∨ R | (P ∨ R) | (¬ Q ∨ R) → P ∨ R | (P ∨ Q) -> (¬ Q ∨ R) -> (P ∨ R)
T T T F T T T T T
T T F F T F T T T
T F T T T T T T T
T F F T T T T T T
F T T F T T T T T
F T F F T F F T T
F F T T F T T T T
F F F T F T F F T

-/
def unit_resolution (P Q : Prop): (P ∨ Q) -> (¬ Q) -> P :=
begin
assume porq nq,
cases porq with pfP pfQ,
exact pfP,
contradiction,
end

def iff_intro (P Q): (P -> Q) -> (Q -> P) -> (P ↔ Q) :=
begin
assume pimpq qimpp,
apply iff.intro,
exact pimpq,
exact qimpp,
end
def iff_elim_left (P Q : Prop): (P ↔ Q) -> (P -> Q) :=
begin
assume pbimpq pfP,
have pimpq : P → Q := pbimpq.1,
exact pimpq pfP,
end
def iff_elim_right (P Q : Prop): (P ↔ Q) -> (Q -> P) :=
begin
assume pbimpq pfQ,
have qimpp : Q → P := pbimpq.2,
exact qimpp pfQ,
end