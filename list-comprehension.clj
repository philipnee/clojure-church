(defn lmap
  [f l]
  (cond
        (empty? l) l
        :else (cons (f (first l))
                       (lmap f (rest l)))))

;(2 3 4)
(lmap inc '(1 2 3))

(defn lreduce
  [f result l]
  (cond
        (empty? l) result
        :else (lreduce f
                        (f result (first l))
                        (rest l))))

;10
(lreduce + 0 '(1 2 3 4 5))
