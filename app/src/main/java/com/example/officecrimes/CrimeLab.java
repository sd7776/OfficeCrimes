package com.example.officecrimes;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//CrimeLab is a singleton class that exists as long as the application stays in the memory, so storing the list
//of crimes in a singleton will keep the crime data available throughout any lifecycle changes in your activities
//and fragments.
public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }

        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        for(int i =0; i< 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i%2 == 0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getmCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime crime: mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
