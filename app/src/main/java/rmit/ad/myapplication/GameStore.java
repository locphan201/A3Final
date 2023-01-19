package rmit.ad.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameStore extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_game_store, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView gameList = view.findViewById(R.id.gamelist);
        gameList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Game> games = new ArrayList<>();
        games.add(new Game("Red Dead Redemption 2", "Rockstar", "Action-Adventure", "2018", 59.99,R.drawable.rdr2));
        games.add(new Game("Forza Horizon 5", "XBox Game Studio", "Racing", "2021", 59.99, R.drawable.fh5));
        games.add(new Game("Dead by Daylight", "Behavior Interactive", "Survival horror", "2016", 19.99, R.drawable.dbd));

        GameStoreAdapter adapter = new GameStoreAdapter(games, getContext());
        gameList.setAdapter(adapter);

        return view;
    }
}