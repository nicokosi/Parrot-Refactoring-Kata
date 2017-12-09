(define (new-parrot parrot . parameters)
    (apply parrot parameters)
)

; simulate class, see http://people.cs.aau.dk/~normark/prog3-03/html/notes/oop-scheme_themes-classes-objects-sec.html
(define (send message obj . args)
    (let
        ((method (obj message)))
        (cond
            ((procedure? method) (apply method args))
            (else (error "Error in method lookup " method)))))

(define (parrot)
    (define (base-speed)
        12.0)
    (define (speed)
        (raise 'Should-be-unreachable)) ; '))
    (define (self message)
        (cond
            ((eq? message 'base-speed) base-speed) ; '))
            ((eq? message 'speed) speed) ; '))
            (else (error "Message not understood" message))))
    self)

(define (european-parrot)
    (let
        ((super (new-parrot parrot)))
        (define (speed)
            (send 'base-speed super)) ; '))
        (define (self message)
            (cond
                ((eq? message 'speed) speed) ; '))
                (else (send super message))))
        self))

(define (african-parrot num-coconuts)
    (let
        ((super (new-parrot parrot)))
        (define (load-factor) 9.0)
        (define (speed)
            (max 0.0 (- (send 'base-speed super) (* (load-factor) num-coconuts))))
        (define (self message)
            (cond
                ((eq? message 'speed) speed) ; '))
                (else (send super message))))
        self))

(define (norwegian-blue-parrot voltage nailed)
    (let
        ((super (new-parrot parrot)))
        (define (compute-base-speed-for-voltage voltage)
            (min 24.0 (* voltage (send 'base-speed super))))
        (define (speed)
            (if nailed 0.0 (compute-base-speed-for-voltage voltage)))
        (define (self message)
            (cond
                ((eq? message 'speed) speed) ; '))
                (else (send super message))))
        self))
