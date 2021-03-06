# clojured-1dca

Simulation of one-dimensional cellular automata in Clojure. 
Read more about 1D CA at http://mathworld.wolfram.com/ElementaryCellularAutomaton.html

## Installation

    $ git clone https://github.com/bakirillov/clojured-1dca.git
    $ cd clojured-1dca
    $ lein uberjar

## Usage

    $ java -jar clojured-1dca [args]

## Options

    -n --number-of-1dca - Number of possible 1D CA;   
    -e --epochs - Number of epochs;   
    -s --seed - Seed value;
    -w --width - Width of a stage;
    

## Examples

### Rule 110 - Turing-complete one
![Alt Text](https://github.com/bakirillov/clojured-1dca/raw/master/rule110.png)

### Rule 30 - Chaotic one
![Alt Text](https://github.com/bakirillov/clojured-1dca/raw/master/rule30.png)

## License

Copyright © 2018 Bogdan Kirillov

Distributed under the Eclipse Public License 1.0.
