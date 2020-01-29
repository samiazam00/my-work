--** Writing functions, recursion:
--see HW 3 for more examples
--  ex. recursive sum function:
def sumto : ℕ → ℕ
| 0 := 0
| (nat.succ n') := (nat.succ n') + sumto n'

-- ex. function that creates a list of string s repeated n times
def repeat : string → ℕ → list string
| s 0 := list.nil
| s (nat.succ n') := list.cons s (repeat s n') 



--** Using Prod:
--ex. we can use "prod" to rep a pair of values:
inductive prod_nat_nat : Type
| pair : ℕ → ℕ → prod_nat_nat

def nn := prod_nat_nat.pair 2 3
#reduce nn



--** High order functions (like map and reduce):

def mmap : (ℕ → ℕ) → list ℕ → list ℕ 
| f [] := []
| f (list.cons h t) := list.cons (f h) (mmap f t)

-- An example application of this function
#eval mmap (λ n, n + 1) [1, 2, 3, 4, 5]



--** Propositions and Proofs:
--ex:
    --propostion:
    def one_eq_one : Prop := --define a proposition with Prop keyword
        1 = 1 --formalize the prop in this line

    def proof_that_one_eq_one : one_eq_one := --define a proof for prop one_eq_one
        (eq.refl 1) -- the proof

    def two_plus_two_eq_four : 2 + 2 = 4 := --2+2=4 is the prop
        eq.refl 4 --this line is the proof


--** Predicate Logic:
  --Predicates are propostions but with parameters, so you can create 
  -- different props with a predicate. Axioms are accepted as true w/o proof.
  
--ex 1 
   --and.intro h1 h2 builds a proof of p ∧ q using proofs h1 : p and h2 : q
       --  example (hp : p) (hq : q) : p ∧ q := and.intro hp hq

   -- and.elim_left h creates a proof of p from a proof h : p ∧ q 
       -- example (h : p ∧ q) : p := and.elim_left h
       -- example (h : p ∧ q) : q := and.elim_right h
   --We can now prove p ∧ q → q ∧ p:
        --example (h : p ∧ q) : q ∧ p := and.intro (and.right h) (and.left h)

-- ex 2 : axioms - 0 is even, and an even number plus 2 is even
    inductive is_even : ℕ → Prop
    | pf_zero_is_even : (is_even 0) --base case: 0 is even is assumed true
    | pf_even_plus_two_is_even : 
        ∀ (n : ℕ), is_even n → is_even (nat.succ (nat.succ n)) 
        --for all n, n is even if n+2 is even 
    
    --ways to check if 0 is even:
    open is_even 
    theorem zero_is_even : is_even 0 :=
        pf_zero_is_even

    theorem zero_is_even' : is_even 0 :=
    begin
        exact pf_zero_is_even
    end

--here's another example with the type Person:
axiom Person : Type
axiom Likes : Person → Person → Prop
example : 
    (∃ (p : Person), ∀ (q : Person), Likes q p) → 
    (∀ (x : Person), ∃ (y : Person), Likes x y ) 
    := 
λ h, 
    λ p, 
        match h with
        | (exists.intro w pf) :=
           exists.intro w (pf p)
        end

example : 
    (∃ (p : Person), ∀ (q : Person), Likes q p) → 
    (∀ (x : Person), ∃ (y : Person), Likes x y ) 
    := 
begin
assume h, --assumes the premise which we do for implies proofs
assume p, -- makes p an arbitrary but specific person who likes another person
cases h with w pf,
exact exists.intro w (pf p)
end
--more deets
/-
The "case" breaks apart the first assume statement into two parts: 
a witness (w) and a proof that everyone likes the person (pf). 
Think of it as cons h t, which breaks up a list into two parts, head and tail.
With exists.intro, we need a witness, and a proof about that witness. 
W is our witness, a person who is liked, and pf is our "function" that takes 
a value and says that they like the witness. In other words the proof says that 
our arbitrary but specific person likes a person, w.
-/


--another example: formalizing predicate logic
--There exist three natural numbers, a, b, and c, such that a^2 + b^2 = c^2:
def py : Prop := ∃ (a b c : ℕ), a^2 + b^2 = c^2

--everyone likes someone:
def everyone_likes_someone : Prop :=
    ∀ (p : Person), ∃ (q : Person), Likes p q

--"likes" is an example of the transitive property:
def likes_is_trans := 
    ∀ (p q r : Person), Likes p q → Likes q r → Likes p r



--** Polymorphic functions:
/-  ex. take a type, α, a value, (s : α), and a nat, n, 
and return a list in which the value, a, is repeated n times. Make
the type argument to this function implicit: -/

def poly_repeat {α : Type} : α → ℕ → list α 
| a 0 := list.nil
| a (nat.succ n') := list.cons a (poly_repeat a n') 

--polymorphic version of mmap function:
def pmap {α β : Type} : (α → β) → list α → list β  
| f [] := []
| f (list.cons h t) := list.cons (f h) (pmap f t)


--** Polymorphic types:
--ex. polymorphic tree type:
inductive tree (α : Type) : Type
| empty : tree  
| value (a : α) (left : tree) (right : tree) : tree 

--now a poly function based on the tree type, take tree α and return tt if empty
open tree
def is_empty (α : Type) : tree α → bool 
| (tree.empty α) := tt
| _ := ff
