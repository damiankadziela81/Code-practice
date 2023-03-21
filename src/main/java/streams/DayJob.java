package streams;

enum DayJob {
    FULL_TIME("Full-time job"),
    PART_TIME("Part-time job");

    String dayJobDescription;

    DayJob(String dayJobDescription){
        this.dayJobDescription = dayJobDescription;
    }
}
