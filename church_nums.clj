(def zero (fn [f] (fn [x] x)))
(def succ (fn [n] (fn [f] (fn [x] (f ((n f) x))))))

;n = n recursive function applications toward zero
(def church-num (fn [n]
                 (loop [n n
                        c zero]
                   (cond
                         (= n 0) c
                         :else (recur (- n 1)
                                      (succ c))))))

;this is how you do 5
(((church-num 5) inc) 0)

;addition
(def add (fn [n]
            (fn [m]
              (fn [f]
                (fn [x]
                  ((n f) ((m f) x)))))))


;lets define some numbers
(def one (church-num 1))
(def two (church-num 2))
(def three (church-num 3))
(def four (church-num 4))
(def five (church-num 5))

;natural number representation
((((add five) three) inc) 0)
