package assignment3.DESIGNPATTERNS.task12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Solution {

    public static void main(String[] args) throws Exception {
        Bowling bowling = new Bowling(9);

        Set<Team> teams = new HashSet<>();
        teams.add(new Team("Hornets", bowling));
        teams.add(new Team("Bloggers", bowling));
        teams.add(new Team("Airmobile", bowling));
        teams.add(new Team("Roll the Ball", bowling));
        teams.add(new Team("Girls don't ball", bowling));
        teams.add(new Team("Granite Balls", bowling));
        teams.add(new Team("Balls of Thunder", bowling));
        teams.add(new Team("We try", bowling));
        teams.add(new Team("Dolls With Balls", bowling));
        teams.add(new Team("Shut up and Roll", bowling));
        teams.add(new Team("Guys and Guys", bowling));
        teams.add(new Team("Alco Rush", bowling));
        teams.add(new Team("Sun! Throw it! Сбей!", bowling));
        teams.add(new Team("Накатя выкати", bowling));

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = executor.invokeAll(teams);
        executor.awaitTermination(5, TimeUnit.SECONDS);

        int sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        System.out.println("Боулинг заработал $" + sum);

        executor.shutdown();
    }
}
