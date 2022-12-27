package exercise;

// BEGIN
class MaxThread extends Thread {

    private int[] numbers;
    private int maximum;

    MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = numbers[0];

        for (int currentNumber : numbers) {
            if (currentNumber > max) {
                max = currentNumber;
            }
        }

        maximum = max;
    }

    public int getMax() {
        return maximum;
    }
}
// END
