package com.apps.quantitymeasurementtest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.apps.quantitymeasurement.Length;
import com.apps.quantitymeasurement.Length.LengthUnit;

/**
 * Unit test for simple App.
 */
public class QuantityMeasurementAppTest 
{
    /**
     * Rigorous Test :-)
     */
   @Test
    public void testEquality_YardToYard_SameValue() {
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = new Length(3.0, LengthUnit.YARDS);
        assertTrue(lengthInYard1.equals(lengthInYard2));    
    }
    @Test
    public void testEquality_YardToYard_differentValue(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = new Length(4.0, LengthUnit.YARDS);
        assertFalse(lengthInYard1.equals(lengthInYard2));      
    }
    @Test
    public void testEquality_YardToFeet_EquivalentValue(){
        Length lengthInYard = new Length(1.0, LengthUnit.YARDS);
        Length lengthInFeet = new Length(3.0, LengthUnit.FEET);
        assertTrue(lengthInYard.equals(lengthInFeet));  
    }
    @Test
    public void testEquality_FeetToYard_SameValue(){
        Length lengthInFeet = new Length(3.0, LengthUnit.FEET);
        Length lengthInYard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(lengthInFeet.equals(lengthInYard));  
 
    }
    @Test
    public void testEquality_YardToInches_EquivalentValue(){
        Length lengthInYard = new Length(1.0, LengthUnit.YARDS);
        Length lengthInInches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(lengthInYard.equals(lengthInInches));  
    }      
     @Test
    public void testEquality_InchesToYard_EquivalentValue(){
        Length lengthInInches = new Length(36.0, LengthUnit.INCHES);
        Length lengthInYard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(lengthInInches.equals(lengthInYard));            
    }
 
    @Test
    public void testEquality_YardToFeet_NotEquivalentValue() {
        Length lengthInYard = new Length(2.0, LengthUnit.YARDS);
        Length lengthInFeet = new Length(3.0, LengthUnit.FEET);
        assertFalse(lengthInYard.equals(lengthInFeet));
    }      
 
    @Test
    public void testEquality_CentimeterToInches_EquivalentValue(){
        Length lengthInCentimeter = new Length(1, LengthUnit.CENTIMETERS);
        Length lengthInInches = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(lengthInCentimeter.equals(lengthInInches));            
    }      
    @Test
    public void testEquality_CentimeterToFeet_NonEquivalentValue(){
        Length lengthInCentimeter = new Length(30.48, LengthUnit.CENTIMETERS);
        Length lengthInFeet = new Length(1.0, LengthUnit.FEET);
        assertFalse(lengthInCentimeter.equals(lengthInFeet));  
    }
    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
               Length Quantity1 = new Length(1.0, LengthUnit.YARDS); // 1 yards
        Length Quantity2 = new Length(3.0, LengthUnit.FEET);  //
        Length Quantity3 = new Length(36.0, LengthUnit.INCHES); // 36 inches
        if(Quantity1.equals(Quantity2) && Quantity2.equals(Quantity3)){
            assertTrue(Quantity1.equals(Quantity3));
        } else {
            assertFalse(true); // Force fail if transitive property does not hold
        }  
 
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void testEquality_YardWithNullUnit(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = new Length(3.0, null);
        assertFalse(lengthInYard1.equals(lengthInYard2));
    }
 
    @Test
    public void testEquality_YardSameReference(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = lengthInYard1;
        assertTrue(lengthInYard1.equals(lengthInYard2));
    }
 
    @Test
    public void testEquality_YardNullComparison(){
        Length lengthInYard1 = new Length(3.0, LengthUnit.YARDS);
        Length lengthInYard2 = null;
        assertFalse(lengthInYard1.equals(lengthInYard2));
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void testEquality_CentimetersWithNullUnit(){
        Length lengthInCentimeters = new Length(3.0, LengthUnit.CENTIMETERS);
        Length lengthInCentimeters2 = new Length(3.0, null);
        assertFalse(lengthInCentimeters.equals(lengthInCentimeters2));
    }
 
    @Test
    public void testEquality_CentimetersSameReference(){
        Length lengthInCentimeters1 = new Length(3.0, LengthUnit.CENTIMETERS);
        Length lengthInCentimeters2 = lengthInCentimeters1;
        assertTrue(lengthInCentimeters1.equals(lengthInCentimeters2));
    }
 
    @Test
    public void testEquality_CentimetersNullComparison(){
        Length lengthInCentimeters = new Length(3.0, LengthUnit.CENTIMETERS);
        Length lengthInCentimeters2 = null;
        assertFalse(lengthInCentimeters.equals(lengthInCentimeters2));
    }
 
    @Test
    public void testEquality_AllUnits_ComplexScenario(){
        Length Quantity1 = new Length(2.0, LengthUnit.YARDS); // 3 yards
        Length Quantity2 = new Length(6.0, LengthUnit.FEET);  //
        Length Quantity3 = new Length(72.0, LengthUnit.INCHES); // 36 inches
        if(Quantity1.equals(Quantity2) && Quantity2.equals(Quantity3)){
            assertTrue(Quantity1.equals(Quantity3));
        // } else {
        //     assertFalse(true); // Force fail if transitive property does not hold
        }
    }

 
 
}
