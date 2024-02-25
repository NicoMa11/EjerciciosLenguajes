(define (eliminar-elemento e l)
  (define (eliminar x)
    (if (equal? x e) #f x))
  (filter identity (map eliminar l)))