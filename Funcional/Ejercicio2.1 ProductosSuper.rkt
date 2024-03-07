(define
  listaProductos
  '(("arroz" 8 1800)
    ("frijoles" 5 1200)
    ("azucar" 6 1100)
    ("cafe" 2 2800)
    ("leche" 9 1200)))

(define
  (agregarProducto Lista nombre cantidad precio)
  (cond ((null? Lista)
         (list (list nombre cantidad precio)))
        ((equal? nombre (caar Lista))
         (cons (list
                (caar Lista)
                (+ (cadar Lista) cantidad) ;(+ (list-ref (car Lista) 1) cantidad)
                precio)
               (cdr Lista)))   
        (else
             (cons (car Lista) (agregarProducto
                   (cdr Lista)
                   nombre cantidad precio)))))

(define (venderProducto lista nombre cantidad)
  (cond ((null? lista)
         (display "No existe ese producto a vender")
         '())
        ((equal? nombre (caar  lista))
         (cons (list
                (caar lista)
                (- (list-ref (car lista) 1) cantidad)
                (list-ref (car lista) 2))
               (cdr lista)))
        (else
         (cons (car lista)
               (venderProducto (cdr lista) nombre cantidad)
               ))))

(define (existenciasMinimas lista cantidad)
  (filter (lambda (x) (<= (cadr x) cantidad))
          lista))

(define factura1 '(("Pollo" 2 5000 10000)
                   ("Papas" 3 1200 3600)
                   ("Zanahorias" 4 600 2400)
                   ("Manzanas" 5 800 4000)
                   ("Pan" 1 2000 2000)))

(define factura2 '(("Jabón" 2 1500 3000)
                   ("Cepillo de dientes" 1 1000 1000)
                   ("Pasta dental" 1 2000 2000)
                   ("Shampoo" 1 2500 2500)
                   ("Crema de afeitar" 1 1800 1800)))


(define (impuestoTotal factura umbral)
  (define (calcularImpuesto monto)
    (* monto 0.13))
  (define (aplicaImpuesto producto)
    (if (> (caddr producto) umbral)
        (calcularImpuesto (* (cadr producto) (caddr producto)))
        0))
  (apply + (map aplicaImpuesto factura)))

(define (montoTotalSinImpuesto factura)
  (apply + (map (lambda (x) (* (cadr x) (caddr x))) factura)))

;; Ejemplo de uso

(displayln "\nFactura 1: Impuesto para productos con precio mayor a 1000")
(displayln (impuestoTotal factura1 1000)) ; Impuesto total para productos con precio mayor a 1500
(displayln (montoTotalSinImpuesto factura1)) ; Monto total sin impuesto de la factura 1


(displayln "\nFactura 2: Impuesto para productos con precio mayor a 2000")
(displayln (impuestoTotal factura2 2000)) ; Impuesto total para productos con precio mayor a 2000
(displayln (montoTotalSinImpuesto factura2))


(displayln "\nFactura 2: Impuesto para productos con precio mayor a 1500")
(displayln (impuestoTotal factura2 1500))
(displayln (montoTotalSinImpuesto factura2)) ; Monto total sin impuesto de la factura 2


