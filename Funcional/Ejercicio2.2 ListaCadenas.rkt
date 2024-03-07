(define (cadena-contiene? cadena_subcadena cadena_aguja)
  (not (equal? #f (regexp-match (regexp (regexp-quote cadena_aguja)) cadena_subcadena))))

(define (subcadenas subcadena lista)
  (filter (lambda (cadena) (cadena-contiene? cadena subcadena)) lista))

(define lista-cadenas '("la casa," "el perro," "pintando la cerca," "reviso el celular," "lavando la ropa," "feo el jueves,"))
(displayln (subcadenas "el" lista-cadenas))
