package streams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {
        while(true){
            System.out.println("Choose your path:");
            System.out.println("1. Intro");
            System.out.println("2. Laziness");
            System.out.println("3. Streams for primitive types");
            System.out.println("4. Reusing streams problem");
            System.out.println("5. Reusing streams solution");
            System.out.println("6. Advanced usage");
            System.out.println("7. Collect");
            System.out.println("8. Collect and grouping");
            System.out.println("9: Flat Map");
            System.out.println("10: Flat Map");
            System.out.println("Q. Quit");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch(choice.toUpperCase()){
                case "1": introduction();
                    break;
                case "2": lazinessOfIntermediateOperations();
                    break;
                case "3": primitiveTypes();
                break;
                case "4": reusingStreamsProblem();
                break;
                case "5": reusingStreamsSolution();
                break;
                case "6": advanced();
                break;
                case "7": streamCollect();
                break;
                case "8": groupingStreams();
                    break;
                case "9": flatMap();
                    break;
                case "10": reduceOperations();
                break;
                case "Q": System.exit(0);
            }
        }
    }

    static void introduction(){
        Stream<String> namesStream = Stream.of("John","Marry","Anabelle","George","Paul","Alice","Ann");

        namesStream
                .filter(e->e.startsWith("A"))   //intermediate operation
                .map(String::toUpperCase)       //intermediate operation
                .sorted()                       //intermediate operation
                .forEach(System.out::println);  //terminal operation

        List<String> namesList = Arrays.asList("John","Marry","Anabelle","George","Paul","Alice","Ann");
        List<String> listOfNames = namesList
                .stream()
                .filter(e->e.length()<6)
                .toList();
        System.out.println(listOfNames);
    }

    static void lazinessOfIntermediateOperations(){
        List<String> namesList = Arrays.asList("John","Marry","Anabelle","George","Paul","Alice","Ann");
        namesList
                .stream()
                .filter(e->{
                    System.out.println("filter: " + e);  //this will never print as there is no terminal operation
                    return true;
                });

        List<String> namesList2 = Arrays.asList("John","Marry","Anabelle","George","Paul","Alice","Ann");
        namesList2
                .stream()
                .filter(e->{
                    System.out.println("filter: " + e);
                    return true;
                })
                .forEach(e-> System.out.println("forEach: " + e));
    }

    static void primitiveTypes() {
        List<String> strings = Arrays.asList("a1","a2","b3","b4","c5","c6");
        strings
                .stream()
                .map(string -> string.substring(1) )
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        IntStream.of(1,2,3,4,5,6)
                .average()
                .ifPresent(System.out::println);

        IntStream.range(1,10)
                .forEach(System.out::println);
    }

    static void reusingStreamsProblem(){
        Stream<String> namesStream = Stream.of("John","Marry","Anabelle","George","Paul","Alice","Ann");
        Predicate<String> hasName = name -> name.equals("Alice");
        namesStream.anyMatch(hasName);
        namesStream.noneMatch(hasName);
    }

    static void reusingStreamsSolution(){
        Supplier<Stream<String>> namesStreamSupplier =
                () -> Stream.of("John","Marry","Anabelle","George","Paul","Alice","Ann");
        Predicate<String> hasName = name -> name.equals("Alice");
        System.out.println("Is Alice in the Stream?: " + namesStreamSupplier.get().anyMatch(hasName));
        namesStreamSupplier.get().noneMatch(hasName);
        namesStreamSupplier.get().allMatch(hasName);
    }

    static void advanced(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, 2000d,"Risk Department", DayJob.FULL_TIME),
                new Employee(2, 2500d,"Scoring Department", DayJob.FULL_TIME),
                new Employee(3, 2600d,"Scoring Department", DayJob.FULL_TIME),
                new Employee(4, 2700d,"Credit Department", DayJob.FULL_TIME),
                new Employee(5, 2700d,"Credit Department", DayJob.PART_TIME)
        );

        employees
                .stream()
                .map(e -> e.getDivision())
                .forEach(System.out::println);

        employees
                .stream()
                .filter(e-> e.getSalary()>2600)
                .forEach(System.out::println);
    }

    static void streamCollect() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, 2000d, "Risk Department", DayJob.FULL_TIME),
                new Employee(2, 2500d, "Scoring Department", DayJob.FULL_TIME),
                new Employee(3, 2600d, "Scoring Department", DayJob.FULL_TIME),
                new Employee(4, 2700d, "Credit Department", DayJob.FULL_TIME),
                new Employee(5, 2700d, "Credit Department", DayJob.PART_TIME)
        );

        Predicate<Employee> salaryPredicate = employee -> employee.getSalary() > 2600;
        List<Employee> filteredEmployeeList = //this list will be immutable!
                employees
                        .stream()
                        .filter(salaryPredicate)
                        .collect(Collectors.toList());
        System.out.println(filteredEmployeeList);

        System.out.println("---------------MAP-------------");
        //collect to map
        try {
            Map<Integer, Employee> employeeMap =
                    employees
                            .stream()
                            .limit(2)
                            .collect(Collectors.toMap(
                                            Employee::getId, //klucz
                                            Function.identity(), //uzycie biezacego elementu kolekcji jako wartosci dla klucza
                                            (key1, key2) -> {
                                                throw new IllegalStateException("duplicate key values found " + key1 + key2);
                                            } //w przypadku kolizji kluczy
                                    )
                            );
            System.out.println(employeeMap);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    static void groupingStreams(){

        List<Employee> employees = Arrays.asList(
                new Employee(1, 2000d, "Risk Department", DayJob.FULL_TIME),
                new Employee(2, 2500d, "Scoring Department", DayJob.FULL_TIME),
                new Employee(3, 2600d, "Scoring Department", DayJob.FULL_TIME),
                new Employee(4, 2700d, "Credit Department", DayJob.FULL_TIME),
                new Employee(5, 2700d, "Credit Department", DayJob.PART_TIME)
        );

        System.out.println("-------------GROUPING-----------------");
        Map<String, List<Employee>> employeesGroupedByDivision =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(e->e.getDivision()));

        employeesGroupedByDivision
                .forEach((division,workers)-> System.out.println(String.format("\nDivision: %s \n%s", division, workers)));


        System.out.println("---------------BY SALARY-----------------");
        Map<Double,List<Employee>> employeesGroupedBySalary =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(e->e.getSalary()));

        employeesGroupedBySalary
                .forEach((salary,workers)-> System.out.println("\nSalary: " + salary + workers));

        System.out.println("------------------BY DAY JOB----------------");
        Map<DayJob,List<Employee>> employeesGropedByDayJob =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(e->e.getDayJob()));
        employeesGropedByDayJob
                .forEach((dayJob,workers)-> System.out.println("\nDayJob: " + dayJob + workers));

        System.out.println("------------------STATS----------------");
        DoubleSummaryStatistics salarySummarizing =
                employees
                        .stream()
                        .collect(Collectors.summarizingDouble(e->e.getSalary()));
        System.out.println(salarySummarizing);

        Double averageSalary = employees
                .stream()
                .collect(Collectors.averagingDouble(e->e.getSalary()));
        System.out.println("Average salary: " + averageSalary);

        System.out.println("------------------JOINING----------------");
        String fullTimeEmployees =
                employees
                        .stream()
                        .filter(e->e.getDayJob().equals(DayJob.FULL_TIME))
                        .map(e->Integer.toString(e.getId()))
                        .collect(Collectors.joining(" , ", "Employees with id's: ", " work full time"));
        System.out.println(fullTimeEmployees);

        System.out.println("-----------------DIVIDING----------------");
        {
            final int chunkSize=3;
            final List<Integer> integers = Arrays.asList(2,4,5,7,8,9,10,12);
            AtomicInteger counter = new AtomicInteger(0);
            Stream<List<Integer>> integerListStream =
                    integers
                            .stream()
                            .collect(Collectors.groupingBy(integer -> counter.getAndIncrement()/chunkSize))
                            .entrySet()
                            .stream()
                            .map(Map.Entry::getValue);
            List<List<Integer>> chunkIntegersList =
                    integerListStream
                            .toList();
            System.out.println(chunkIntegersList);

        }

    }

    static void flatMap(){
        final List<List<Integer>> slicedIntegers = Arrays.asList(
                Arrays.asList(2,4,6),
                Arrays.asList(8,10,12),
                Arrays.asList(14,16)
        );
        final List<Integer> simpleIntegerList =
                slicedIntegers
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
        System.out.println("slicedIntegers: " + slicedIntegers);
        System.out.println("simpleIntegers: " + simpleIntegerList);
    }

    static void reduceOperations(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, 2000d, "Risk Department", DayJob.FULL_TIME),
                new Employee(2, 2500d, "Scoring Department", DayJob.FULL_TIME),
                new Employee(3, 2600d, "Scoring Department", DayJob.FULL_TIME),
                new Employee(4, 2700d, "Credit Department", DayJob.FULL_TIME),
                new Employee(5, 2700d, "Credit Department", DayJob.PART_TIME)
        );

        Double salariesSumForFullTimeEmployees =
                employees
                        .stream()
                        .filter(e->e.getDayJob().equals(DayJob.FULL_TIME))
                        .map(Employee::getSalary)
                        .reduce(0.0,Double::sum);
        System.out.println("Salaries sum for full-time workers: " + salariesSumForFullTimeEmployees);

        //Porównujemy zarobki osób zatrudnionych na pełny etat i zwracamy dane pracownika z najwyższą pensją.
        employees
                .stream()
                .filter(employee -> employee.getDayJob().equals(DayJob.FULL_TIME))
                .reduce((employee1, employee2) -> employee1.getSalary() > employee2.getSalary() ? employee1 : employee2)
                .ifPresent(System.out::println);

    }
}
