package rmit.ad.myapplication;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class GameLibrary extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_game_library, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView gameList = view.findViewById(R.id.gamelib);
        gameList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Game> games = new ArrayList<>();
        // populate the games list with data
        games.add(new Game("Grand Theft Auto V", "Rockstar", R.drawable.gtav));
        games.add(new Game("Resident Evil 2", "Capcom", R.drawable.re2));
        games.add(new Game("Back 4 Blood", "Turtle Rock Studio", R.drawable.b4b));


        GameLibAdapter adapter = new GameLibAdapter(games, getContext());
        gameList.setAdapter(adapter);

        return view;
    }
}