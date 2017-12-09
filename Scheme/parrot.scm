(define (parrot)
    (define (base-speed) 12.0)
    (lambda () (raise 'Should-be-unreachable)) ; '))
)

(define (new-parrot parrot . parameters)
    (apply parrot parameters)
)

; simulate class, see http://people.cs.aau.dk/~normark/prog3-03/html/notes/oop-scheme_themes-classes-objects-sec.html
(define (send message obj . args)
    (let
        ((method (obj message)))
        (cond
            ((procedure? method) (apply method args))
            (else (error "Error in method lookup " method))
        )
    )
)

(define (european-parrot)
    (define (base-speed) 12.0)
    (define (speed)
        (base-speed))
    (define (self message)
        (cond
            ((eq? message 'speed) speed) ; '))
            (else (error "Message not understood" message))))
    self
)

(define (african-parrot num-coconuts)
    (define (base-speed) 12.0)
    (define (load-factor) 9.0)
    (define (speed)
        (max 0.0 (- (base-speed) (* (load-factor) num-coconuts))))
    (define (self message)
        (cond
            ((eq? message 'speed) speed) ; '))
            (else (error "Message not understood" message))))
    self
)

(define (norwegian-blue-parrot voltage nailed)
    (define (base-speed) 12.0)
    (define (compute-base-speed-for-voltage voltage)
        (min 24.0 (* voltage (base-speed))))
    (define (speed)
        (if nailed 0.0 (compute-base-speed-for-voltage voltage)))
    (define (self message)
        (cond
            ((eq? message 'speed) speed) ; '))
            (else (error "Message not understood" message))))
    self
)
