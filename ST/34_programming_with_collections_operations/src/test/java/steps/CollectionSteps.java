package steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jfree.chart.ChartUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CollectionSteps {

    final static int max = 10000;

    @ParameterType("ArrayList|LinkedList|Vector|Stack|ArrayDeque|HashSet|TreeSet|LinkedHashSet")
    public String collectionType(String string) {
        return string;
    }

    private static final Logger logger = LoggerFactory.getLogger(CollectionSteps.class);
    private final Map<String, Collection<Integer>> collections = new HashMap<>();
    private final Map<String, Long> performanceResults = new HashMap<>();

    @Given("I have an empty {string} collection")
    public void i_have_an_empty_collection(String collectionType) {
        Collection<Integer> collection;
        switch (collectionType) {
            case "ArrayList":
                collection = new ArrayList<>();
                break;
            case "LinkedList":
                collection = new LinkedList<>();
                break;
            case "HashSet":
                collection = new HashSet<>();
                break;
            case "TreeSet":
                collection = new TreeSet<>();
                break;
            case "LinkedHashSet":
                collection = new TreeSet<>();
                break;
            default:
                throw new IllegalArgumentException("Unknown collection type: " + collectionType);
        }
        collections.put(collectionType, collection);
        logger.info("Created an empty {}", collectionType);
    }

    @Given("I have the {string} collection with {int} random numbers")
    public void i_have_the_collection(String collectionType, int count) {
        Collection<Integer> collection;
        switch (collectionType) {
            case "ArrayList":
                collection = new ArrayList<>();
                break;
            case "LinkedList":
                collection = new LinkedList<>();
                break;
            case "HashSet":
                collection = new HashSet<>();
                break;
            case "TreeSet":
                collection = new TreeSet<>();
                break;
            case "LinkedHashSet":
                collection = new TreeSet<>();
                break;
            default:
                throw new IllegalArgumentException("Unknown collection type: " + collectionType);

        }
        collection = addRandomNumbersToCollection(count, collection);
        collections.put(collectionType, collection);
        logger.info("Created the {}", collectionType);
    }

    @When("I add {int} random numbers to the collections")
    public void i_add_random_numbers_to_the_collections(int count) {
        collections.forEach((name, collection) -> {
            long startTime = System.nanoTime();
            collection = addRandomNumbersToCollection(count, collection);
            long duration = System.nanoTime() - startTime;
            performanceResults.put(name, duration);
            logger.info("Added {} random numbers to {} in {} ms", count, name, TimeUnit.NANOSECONDS.toMillis(duration));
        });
    }

    @When("I search for {int} random elements in the collections")
    public void i_search_for_elements_in_the_collections(int count) {
        Random rand = new Random();
        collections.forEach((name, collection) -> {
            long totalTime = 0;

            for (int i = 0; i < count; i++) {
                int elementToFind = rand.nextInt(max);

                long startTime = System.nanoTime();
                boolean found = collection.contains(elementToFind);
                long duration = System.nanoTime() - startTime;
                totalTime += duration;

                logger.info("Element {} {} found in {} in {} ns", elementToFind, found ? "was" : "was not", name, duration);
            }

            long averageTime = totalTime / count;
            performanceResults.put(name + "Search", totalTime);
            logger.info("Average Time search time for {} in {} is {} ns", count, name, averageTime);
        });
    }


    public Collection addRandomNumbersToCollection(int count, Collection<Integer> collection) {
        Random rand = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            collection.add(rand.nextInt(max));
        }
        long duration = System.nanoTime() - startTime;
        logger.info("Added {} random numbers to {} in {} ms", count, collection.getClass().getSimpleName(), TimeUnit.NANOSECONDS.toMillis(duration));
        return collection;
    }

    @When("I remove first {int} elements from the collections")
    public void i_remove_elements_from_the_collections(int count) {
        collections.forEach((name, collection) -> {
            long startTime = System.nanoTime();

            for (int i = 0; i < count && !collection.isEmpty(); i++) {
                if (collection instanceof List) {
                    ((List) collection).remove(0);
                } else {
                    Iterator<Integer> iterator = collection.iterator();
                    iterator.next();
                    iterator.remove();
                }
            }

            long duration = System.nanoTime() - startTime;

            performanceResults.put(name + "Remove", duration);
            logger.info("Removed {} elements from {} in {} ms", count, name, TimeUnit.NANOSECONDS.toMillis(duration));
        });
    }

    @When("I randomly remove {int} elements from the first half of the collections")
    public void i_randomly_remove_elements_from_the_first_half_of_the_collections(int count) {
        Random rand = new Random();
        collections.forEach((name, collection) -> {
            long startTime = System.nanoTime();
            int size = collection.size();
            int halfSize = size / 2;

            for (int i = 0; i < count && !collection.isEmpty(); i++) {
                int removeIndex = rand.nextInt(Math.min(halfSize, collection.size()));

                if (collection instanceof List) {
                    ((List) collection).remove(removeIndex);
                } else {
                    Iterator<Integer> iterator = collection.iterator();
                    for (int j = 0; j <= removeIndex; j++) {
                        iterator.next();
                    }
                    iterator.remove();
                }
            }

            long duration = System.nanoTime() - startTime;

            performanceResults.put(name + "RandomRemove" + count, duration);
            logger.info("Randomly removed {} elements from the first half of {} in {} ms", count, name, TimeUnit.NANOSECONDS.toMillis(duration));
        });
    }

    @When("I sort the collections")
    public void i_sort_the_collections() {
        collections.forEach((name, collection) -> {
            if (!(collection instanceof List)) {
                logger.error("Collection of type {} cannot be sorted directly. It must be converted to a List.", collection.getClass().getSimpleName());
                return;
            }

            List<Integer> list = (List<Integer>) collection;

            long startTime = System.nanoTime();
            Collections.sort(list); // Сортировка списка
            long duration = System.nanoTime() - startTime;

            performanceResults.put(name + "Sort", duration);
            logger.info("Sorted {} in {} ms", name, TimeUnit.NANOSECONDS.toMillis(duration));
        });
    }

    @Then("I should measure and compare the performance of operations for {string} and {string} collections for {string} operation")
public void i_should_measure_and_compare_the_performance_of_operations(String collectionName1, String collectionName2, String operation) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        performanceResults.forEach((name, duration) -> {
            dataset.addValue(TimeUnit.NANOSECONDS.toMillis(duration), "Time", name);
        });

        JFreeChart barChart = ChartFactory.createBarChart(
                "Collection Performance ",
                "Collection Type",
                "Time in ms",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        try {
            String chartsDirPath = "charts";
            File chartsDir = new File(chartsDirPath);

            if (!chartsDir.exists()) {
                boolean wasDirectoryMade = chartsDir.mkdirs();
                if (!wasDirectoryMade) {
                    logger.error("Failed to create directory for charts.");
                    return;
                }
            }

            File barChartFile = new File(chartsDirPath + File.separator +"CollectionPerformanceChart_" + operation + "_" + collectionName1 + "_vs_" + collectionName2 + ".png");

            int width = 640;
            int height = 480;
            ChartUtils.saveChartAsPNG(barChartFile, barChart, width, height);
            logger.info("Chart saved as '{}'", barChartFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Problem occurred creating chart.", e);
        }
    }
}