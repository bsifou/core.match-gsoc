
(try
  (cond
    (= y false) (try
                  (cond (= z true) 1
                        :else (throw backtrack))
                  (catch Exception e
                    (if (identical? e backtrack)
                      (throw backtrack)
                      (throw e))))
    
    :else (throw backtrack))
  (catch Exception e
    (if (identical? e backtrack)
      (do
        (try
          (cond
            (= y true) (try (cond
                              (= x false) 2
                              :else (throw backtrack))
                            (catch Exception e
                              (if (identical? e backtrack)
                                (throw backtrack)
                                (throw e))))
            :else (throw backtrack))
          (catch Exception e
            (if (identical? e backtrack)
              (do (try
                    (cond
                      (= z false) 3
                      :else (trhow backtrack))
                    (catch  Exception e
                      (if (identical? e backtrack)
                        (do (try
                              (cond
                                (= z true) 4
                                :else (throw backtrack))
                              (catch Exception e
                                (if (identical? e backtrack)
                                  (throw no-matching-e)
                                  (throw e)))))
                        (throw e)))))
              (throw e)))))
      (throw e))))

;; this should be

(cond (= y false)  (cond (= z true) 1)
      (= y true) (cond (= x false) 2
                       (= z false) 3
                       (= z true) 4))



; loop + jump table (via case) | not cond? 






