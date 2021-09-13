package com.example.f1mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.f1mobile.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView textview;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        textview = fragmentFirstLayout.findViewById(R.id.textview_first);

        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.senddata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer currentCount = Integer.parseInt(textview.getText().toString());
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);
            }


        });

        view.findViewById(R.id.getraces_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                Toast toast = Toast.makeText(getActivity(), "HI", Toast.LENGTH_SHORT);
//                toast.show();
                getRaces(view);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getRaces(View view){
        // Get the value of the text view
        String countString = textview.getText().toString();

        // Convert value to a number and increment it
        Integer count = Integer.parseInt(countString);
        count++;
        // Display the new value in the text view.
        textview.setText(count.toString());
    }

}