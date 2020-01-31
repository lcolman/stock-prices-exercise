# stock-prices-exercise
A simple algorithm exercise, taken from [Jonathan Gomez @ Latitude](https://gist.github.com/jonog/54e46b5b1200758d222e3c4cf61baaa6).

The task of the algorithm is the return the maximum profit that could have been achieved by buying and selling stock in yesterdays market.
For the purposes of the algorithm:
 * Only one purchase and one sale can occur.
 * The purchase must occur before the sale.
 * At least one unit of time must pass after buying before you are allowed to sell (a settlement 'holding' period).
 Goals are that the algorithm should be as efficient as possible.


## Solution Design
### Efficiency
As the problem statement asked specifically for an efficient algorithm, I chose to implement the code as a single-pass through the problem array.

I also decided to try to implement a solution that had a constant memory footprint in terms on number of variables within the loop iteration.
To achieve this I use only value types, such as boolean and int within the function.
I also decided to try to attempt a solution that kept no index references within the array, and was just a simple one-way list iteration approach.

### Assumptions
For the solution development to this problem I assumed the following:
 * Java Integer/int type bounds would suffice for all values (we will not have a share price of more than 2^32, although that would be awesome).
 * There would be a non-infinite and computationally representable number of array indicies (given a day only has 1,440 minutes).
 * Stock prices may be positive or negative - this enables the algorithm to be used to produce profits for securities other than just stocks.

### Verifiability
In order to establish confidence around the algorithmic solution, I developed 16 unit test cases:
 * Four tests which ensure the algorithm solves certain basic problems (such as naieve cases, global maxima, etc),
 * Four that test basic sanity conditions which should result in zero profit (empty array, only 1 index, etc),
 * Three that test the algorithm as it approaches, operates upon, or receedes from boundary values,
 * Two that test the requirement for purchase and sale to be separated by one time step, and
 * Three that test the algorithm with the presence of negative numbers (as per my design assumptions above).

 More detail of the expectations and design intent of each of these test cases is available within the code as comments.

## Chosen language
*Java*
with Maven for dependency management.

## Run
Can be run via `mvn test`.  Requires working Maven and JDK setup.
