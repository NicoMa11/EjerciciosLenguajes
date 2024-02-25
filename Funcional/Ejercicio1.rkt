(define (calcular-monto capital interes años)
  (define (calcular-interes capital interes)
    (* capital interes))
  (define (calcular-monto-recursivo capital interes años)
    (if (= años 0)
        capital
        (calcular-monto-recursivo (+ capital (calcular-interes capital interes)) interes (- años 1))))
  (calcular-monto-recursivo capital interes años))
