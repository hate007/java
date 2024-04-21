<%!
    public boolean checkPerfectNumber(int number) {
        int sum = 1; 
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i * i != number) {
                    sum += number / i;
                }
            }
        }
        return sum == number && number != 1;
    }
%>
