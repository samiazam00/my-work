; Samreen Azam(sa3tnc)
; 11/17/19
; threexplusone.s

	global threexplusone

	section .text

; Optimizations: I used the lea command for adding/multiplying.
; I also used bit shifts instead of idiv. Finally, I reduced the
; number of commands by using fewer registers and cutting out
; unnecessary lines (ex. took out resetting the base pointer
; and storing values in extra registers because that didn't change result) 
	
threexplusone:			;prologue
	xor rax, rax		;zero out rax
	cmp rdi, 1		;base case - if(x == 1)
	je end			;if yes, jump to end and return	
	test rdi, 1		;else, do a bitwise check
	jnz odd			;lowest bit = 1, so go to odd
	jz even			;else go to even
	
even:
	push rdi		;push input
	sar rdi, 1		;bit shift for x/2
	call threexplusone	;recursive call
	inc rax			;increment step result
	pop rdi			;pop to get value
	jmp end			;jump to end

odd:
	push rdi		;push input 
	lea rdi, [1+3*rdi]	;1 + (3*x)
	call threexplusone	;recursive call
	inc rax			;increment step result
	pop rdi			;get result
	jmp end			;jump to end

end:	 			;epilogue 
	ret			;return result
