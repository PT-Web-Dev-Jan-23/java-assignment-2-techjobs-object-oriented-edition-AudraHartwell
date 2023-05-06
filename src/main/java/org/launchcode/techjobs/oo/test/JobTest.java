package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1= new Job();
        Job job2= new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
       Job job=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         assertTrue(job instanceof Job);

         assertEquals("Product tester", job.getName());
         assertTrue(job.getEmployer() instanceof Employer);
         assertEquals("ACME",job.getEmployer().getValue());
         assertTrue(job.getLocation() instanceof Location);
         assertEquals("Desert",job.getLocation().getValue());
         assertTrue(job.getPositionType() instanceof PositionType);
         assertEquals("Quality control", job.getPositionType().getValue());
         assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
         assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1= new Job();
        Job job2= new Job();
        assertFalse(job1.getId()==(job2.getId()));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char expectedCharAtBegin = '\n';
        char actualBegin = job.toString().charAt(0);
        char expectedCharAtEnd = '\n';
        char actualEnd = job.toString().charAt((job.toString().length()-1));
    assertEquals(expectedCharAtBegin,actualBegin);
    assertEquals(expectedCharAtEnd,actualEnd);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job=new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedJob = "\n" +
                "ID: 2\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                "\n";
        String actual = job.toString();
        assertEquals(expectedJob, actual);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job=new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String expected =
                "\n" +
                "ID: 1\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Persistence" +
                "\n";
        String actual = job.toString();
        assertEquals(expected, actual);
    }

}
