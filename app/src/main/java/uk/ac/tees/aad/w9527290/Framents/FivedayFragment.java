package uk.ac.tees.aad.w9527290.Framents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.activities.Goal_5day;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FivedayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FivedayFragment extends Fragment {

    Button btn;
    Button Accept;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FivedayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FivedayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FivedayFragment newInstance(String param1, String param2) {
        FivedayFragment fragment = new FivedayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fiveday, container, false);

        btn = view.findViewById(R.id.button2);
        Accept = view.findViewById(R.id.button);
        Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getApplicationContext(), Goal_5day.class);
                startActivity(intent);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://health.clevelandclinic.org/the-many-benefits-of-a-cardio-workout/"));
                startActivity(viewIntent);
            }
        });
        return  view;
    }
}