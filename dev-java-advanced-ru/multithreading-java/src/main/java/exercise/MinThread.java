package exercise;

// BEGIN
class MinThread extends Thread {

    private int[] numbers;
    private int minimum;

    MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int min = numbers[0];

        for (int currentNumber : numbers) {
            if (currentNumber < min) {
                min = currentNumber;
            }
        }

        minimum = min;
    }

    public int getMin() {
        return minimum;
    }
}
// END
