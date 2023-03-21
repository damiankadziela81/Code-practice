package streams;

class Employee {
    private int id;
    private double salary;
    private String division;
    private DayJob dayJob;

    Employee(final int id, final double salary, final String division, final DayJob dayJob) {
        this.id = id;
        this.salary = salary;
        this.division = division;
        this.dayJob = dayJob;
    }

    int getId() {
        return id;
    }

    double getSalary() {
        return salary;
    }

    String getDivision() {
        return division;
    }

    DayJob getDayJob() {
        return dayJob;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Employee {");
        stringBuilder.append(" \nid: ").append(this.id);
        stringBuilder.append(", \nsalary: ").append(this.salary);
        stringBuilder.append(", \ndivision: ").append(this.division);
        stringBuilder.append(", \ndayJob: ").append(this.dayJob);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
