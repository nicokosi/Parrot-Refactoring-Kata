; simulate class, see http://people.cs.aau.dk/~normark/prog3-03/html/notes/oop-scheme_themes-classes-objects-sec.html
(define (new-instance parrot . parameters)
    (apply parrot parameters))

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
    ; class infrastructure
    (define (self message)
        (cond
            ((eq? message 'base-speed) base-speed) ; '))
            ((eq? message 'speed) speed) ; '))
            (else (error "Message not understood" message))))
    self)

(define (european-parrot)
    (let
        ((super (new-instance parrot)))
        (define (speed)
            (send 'base-speed super)) ; '))

        ; class infrastructure
        (define (self message)
            (cond
                ((eq? message 'speed) speed) ; '))
                (else (send super message))))
        self))

(define (african-parrot num-coconuts)
    (let
        ((super (new-instance parrot)))
        (define (slowdown-due-coconuts) (* (load-factor) num-coconuts))
        (define (load-factor) 9.0)
        (define (speed)
            (max 0.0 (- (send 'base-speed super) (slowdown-due-coconuts)))) ; '))))

        ; class infrastructure
        (define (self message)
            (cond
                ((eq? message 'speed) speed) ; '))
                (else (send super message))))
        self))

(define (norwegian-blue-parrot voltage nailed)
    (let
        ((super (new-instance parrot)))
        (define (max-speed) 24.0)
        (define (speed-for-voltage)
            (min (max-speed) (* voltage (send 'base-speed super)))) ; '))))
        (define (speed)
            (if nailed
                0.0
                (speed-for-voltage)))

        ; class infrastructure
        (define (self message)
            (cond
                ((eq? message 'speed) speed) ; '))
                (else (send super message))))
        self))
