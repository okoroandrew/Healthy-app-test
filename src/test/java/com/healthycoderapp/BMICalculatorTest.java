package com.healthycoderapp;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Nested
    class IsDietRecommended{
        @ParameterizedTest(name = "weight={0}, height={1}")
        @CsvSource({"80, 1.65", "90, 1.7", "100, 1.8", "110, 1.75"})
        void shouldReturnTrueWhenRecommended(double coderWeight, double coderHeight){
            //Given
            //When
            boolean dietRecommended = BMICalculator.isDietRecommended(coderWeight, coderHeight);
            //Then
            assertTrue(dietRecommended);
        }

        @ParameterizedTest(name = "weight={0}, height={1}")
        @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
        void shouldReturnTrueWhenRecommended2(double coderWeight, double coderHeight){
            //Given
            //When
            boolean dietRecommended = BMICalculator.isDietRecommended(coderWeight, coderHeight);
            //Then
            assertTrue(dietRecommended);
        }

        @ParameterizedTest(name = "weight={0}")
        @ValueSource( doubles = {80, 90, 100})
        void shouldReturnTrueWhenRecommended3(double coderWeight){
            //Given
            double coderHeight = 1.7;
            //When
            boolean dietRecommended = BMICalculator.isDietRecommended(coderWeight, coderHeight);
            //Then
            assertTrue(dietRecommended);
        }

        @Test
        void shouldReturnFalseWhenNotRecommended(){
            //given
            double weight = 50;
            double height = 1.9;
            //when
            boolean dietRecommended = BMICalculator.isDietRecommended(weight, height);
            //then
            assertFalse(dietRecommended);
        }

        @Test
        void shouldThrowArithmeticException(){
            //given
            double weight = 50;
            double height = 0;
            //when
            Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
            //then
            assertThrows(ArithmeticException.class, executable);
        }
    }

    @Nested
    class CodersWithWorstBMI{

        @Test
        void shouldReturnCoderWithWorstBMIWhenCoderListIsNotEmpty(){
            //given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(1.80, 60));
            coders.add(new Coder(1.82, 98));
            coders.add(new Coder(1.82, 66.7));
            //when
            Coder coder = BMICalculator.findCoderWithWorstBMI(coders);
            //then
            assertAll(
                    () -> assertEquals(1.82 ,coder.getHeight()),
                    () -> assertEquals(98 ,coder.getWeight())
            );

        }

        @Test
        void shouldReturnTrueWhenCoderListIsEmpty(){
            //given
            List<Coder> coders = new ArrayList<>();
            //when
            Coder coder = BMICalculator.findCoderWithWorstBMI(coders);
            //then
            assertNull(coder);

        }

    }

    @Nested
    class GetBMIScore{

        @Test
        void shouldReturnCorrectBMIScoreWhenCodersListNotEmpty(){
            //given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(1.80, 60));
            coders.add(new Coder(1.82, 98));
            coders.add(new Coder(1.82, 66.7));
            double[] expectedBMI = {18.52, 29.59, 20.14};
            //when
            double[] BMIScores = BMICalculator.getBMIScores(coders);
            //then
            assertArrayEquals(expectedBMI, BMIScores);
        }
    }

}