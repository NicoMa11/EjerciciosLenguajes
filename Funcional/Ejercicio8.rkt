(define (sub-conjunto? subconjunto conjunto)
  (cond
    ((null? subconjunto) #t) ; Un conjunto vacío es subconjunto de cualquier conjunto
    ((member (car subconjunto) conjunto) (sub-conjunto? (cdr subconjunto) conjunto))
    (else #f)))