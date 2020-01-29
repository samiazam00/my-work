axiom P : Prop
axiom Q : Prop 
axiom q : Q  --assume Q is a proposition and q is a proof of Q

-- 2 induction rules for OR: or.inl takes a proof of P and returns a proof of P v Q 
-- inr takes a proof of Q and returns a proof of P v Q (ex of polymorphism)
example : P ∨ Q := or.inr q
-- ima, kono bishounen wa watashi no tonari ni suwaru.....
-- uwaa chotto kinchou suruuuu, kare no me wa meccha kakkoiiii
-- soshite, kare no hada wa kireiii kyaaaahh 
example : 0 = 1 ∨ 2 = 2 := or.inr (eq.refl 2) 

example : (P ∧ Q) ∨ Q := or.inr q

--Constructive Logic:
example : P ∨ ¬ P :=
begin 
_
end  

--Classical Logic 
axiom em : ∀ (P: Prop), P ∨ ¬ P
#check em

--for any propositon P, not not P implies P (¬ ¬ P = true if P = true)
example : ∀ (P : Prop), ¬ (¬ P) → P :=
begin 
assume P,
assume (nnp : ¬ ¬ P),
cases (em P), 
exact h,
have f : false := (nnp h),
exact false.elim f
end 

