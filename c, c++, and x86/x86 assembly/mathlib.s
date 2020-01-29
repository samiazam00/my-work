; Samreen Azam (sa3tnc)
; 11/3/19  
; mathlib.s
; Purpose: implement subroutines for computing the product of 2 numbers and the   power of a number to another number (all positive)
	global product
	global power
	section .text

product:
	xor rax, rax 		; zero out return register
	xor r10, r10		; zero out counter i
	mov r11, rdi 		; move param 1 to caller saved register

start:
	cmp r10, rsi		; check if i == n
	je prod_done		; if so, we are done with the loop
	add rax, r11	 	; add value to reg
	inc r10		 	; increment  counter i
	jmp start		; end loop iteration

prod_done:
	ret			;standard epilogue
	
power:				;standard prologue
	xor rax, rax
	mov r10, rdi
	mov r11, rsi		;move param 2 to cs reg
	cmp r11, 0		;check if y == 0
	je pow_done		;if so, end
	jg loop			;else jump to loop

loop:
	dec r11			; decrement y
	push r11		; push y value onto the stack first
	push r10		; push x value on stack
	call power		; recursively calculate power function
	push rax		; push the answer onto stack
	push r10		
	call product
	
pow_done:
	ret

