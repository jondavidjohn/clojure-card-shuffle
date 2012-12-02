# Clojure Card Shuffle

A simple clojure module that is meant to simulate the action of shuffling
a collection as if it were a deck of cards.

## Types

All shuffle types support an optional second parameter to perform the shuffle multiple times.

### Riffle - http://en.wikipedia.org/wiki/Shuffling#Riffle

  Predictable behaviours that make a human riffle shuffle imperfect

  - Once a deck of cards is divided to each hand, the amount of cards in each hand is not (likely) equal.
  - As each thumb releases from it's half of the deck, sometimes more than one card drops from a single hand at a time.

```clojure
(riffle coll times)
```

### Overhand - http://en.wikipedia.org/wiki/Shuffling#Stripping_or_overhand

  Predictable behaviours that make a human overhand shuffle imperfect

  - Random amounts of cards (chunks) are taken from the top and placed placed in the opposite hand in reverse order (retaining the order within each chunk)

```clojure
(overhand coll times)
```

### Mongean - http://en.wikipedia.org/wiki/Shuffling#Mongean_shuffle

  A very predictable shuffle, alternating placing the top card on the bottom/top of the new deck

__unit tests included__

```clojure
(mongean coll times)
```

### Pile - http://en.wikipedia.org/wiki/Shuffling#Pile_shuffle

  Predictable shuffle, dealing items into N piles and then rejoining the piles

__unit tests included__

```clojure
; `piles` is how many piles to use
(pile coll piles times)
```


## Installation

**Available via clojars.org**
