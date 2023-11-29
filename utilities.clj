(ns utilities)
; https://stackoverflow.com/a/71872354
(defn seek
  "Call the given predicate, pred, on successive elements of the collection
  until the first time pred returns a truthy value, at which time if-found
  is called with that element of the collection, and seek returns
  the return value of if-found.   If no such element of collection is found
  (including if collection is empty) then the value if-not-found (defaulting
  to false) is returned."
  ([pred coll]
   (reduce (fn [_ item]
             (if (pred item) (reduced item) nil))
           nil
           coll)))