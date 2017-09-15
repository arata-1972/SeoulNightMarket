package seoulnightmarket.seoulnightmarket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

public class FragmentMarket extends Fragment {
    public int foodTruck[] = {R.drawable.herotruck, R.drawable.shimlimphinhiya, R.drawable.chickenfit, R.drawable.imsteak, R.drawable.jayfresh, R.drawable.pandagrill};
    public int handMade[] = {R.drawable.andro, R.drawable.babo, R.drawable.bom, R.drawable.soso};
    public String type = "foodTruck";
    public CustomAdapter adapter;
    public GridView gridView;
    public String foodTruckName[] = {"hero truck", "쉬림프컵히야", "치킨핏", "아임 스테이크", "제이프레시", "팬더그릴"};
    public String handMadeName[] = {"안드로행성712공방", "바보공방", "봄이네", "소소공방"};
//    public ArrayList<String> foodTruckName = new ArrayList<String>();
//    public ArrayList<String> handMadeName = new ArrayList<String>(); // 서버에서 데이터 받아올때 어레이리스트 쓸 것

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_market, container, false);

        if (type == "foodTruck") {
            adapter = new CustomAdapter(view.getContext(), foodTruck, foodTruckName);
        } else if (type == "handMade") {
            adapter = new CustomAdapter(view.getContext(), handMade, handMadeName);
        }

        gridView = view.findViewById(R.id.gridView);
        gridView.setAdapter(adapter); // 그리드뷰에 어댑터 연결

        Button btnFoodTruck = view.findViewById(R.id.foodTruck);
        btnFoodTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "foodTruck";

                if (type == "foodTruck") {
                    adapter = new CustomAdapter(getActivity().getApplicationContext(), foodTruck, foodTruckName);
                    gridView.invalidateViews();
                    gridView.setAdapter(adapter);
                }
            }
        });

        Button btnHandMade = view.findViewById(R.id.handMade);
        btnHandMade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "handMade";

                if (type == "handMade") {
                    adapter = new CustomAdapter(getActivity().getApplicationContext(), handMade, handMadeName);
                    gridView.invalidateViews();
                    gridView.setAdapter(adapter);
                }
            }
        });

        return view;
    }
}