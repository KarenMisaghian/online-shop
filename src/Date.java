public class Date {
    private int month;
    private int year;
    private int day;
    private int value;

    public Date(int month, int year, int day) {
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public boolean dateValid() {
        boolean isValid = false;
        boolean dayValid = this.day > 0 && this.day <= 31;
        boolean yearValid = this.year > 1000 && this.year < 1500;
        boolean monthValid = this.month > 0 && this.month <= 12;
        if (dayValid && yearValid && monthValid) {
            isValid = true;
        }
        return isValid;
    }

    public void printDate() {
        System.out.println("Day: " + this.day);
        System.out.println("Month: " + this.month);
        System.out.println("Year: " + this.year);
    }

    public void calculateValue() {
        this.value += this.year * 365;
        this.value += this.month * 30;
        this.value += this.day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

}
