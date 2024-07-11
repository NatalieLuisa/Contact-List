package com.nataliemontesino.mycontactlist;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DatePickerDialog extends DialogFragment {

    Calendar selectedDate;

    public interface SaveDateListener {
        void didFinishDatePickerDialog(Calendar selectedTime);
    }

    public DatePickerDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.select_date, container);

        getDialog().setTitle("Select Date");
        selectedDate = Calendar.getInstance();

        final CalendarView cv = view.findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                selectedDate.set(year, month, day);
            }
        });

        Button saveButton = view.findViewById(R.id.buttonSelect);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem(selectedDate);
            }
        });
        Button cancelButton = view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return view;
    }

    private void saveItem(Calendar selectedTime) {
        SaveDateListener activity = (SaveDateListener) getActivity();
        activity.didFinishDatePickerDialog(selectedTime);
        getDialog().dismiss();
    }

}
/*
 * The DatePickerDialog class extends DialogFragment and provides a date picker dialog for selecting a date.
 *
 * Key functionalities include:
 * - Displaying a CalendarView for users to select a date.
 * - Handling the selection of a date and passing the selected date back to the calling activity.
 *
 * Key methods and components include:
 * - onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState): Inflates the dialog layout, initializes the CalendarView, and sets up the listeners for date selection and button clicks.
 * - saveItem(Calendar selectedTime): Retrieves the selected date and passes it back to the calling activity through the SaveDateListener interface, then dismisses the dialog.
 * - CalendarView.OnDateChangeListener: Updates the selectedDate when the user selects a new date on the CalendarView.
 * - SaveDateListener interface: Defines a callback method (didFinishDatePickerDialog) that the calling activity must implement to receive the selected date.
 *
 * The class ensures that the user can select a date easily and that the selected date is communicated back to the calling activity in a consistent manner.
 */

