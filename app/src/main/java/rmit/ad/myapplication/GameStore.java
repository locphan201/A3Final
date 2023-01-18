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

public class GameStore extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_game_store, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView gameList = view.findViewById(R.id.gamelist);
        gameList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Game> games = new ArrayList<>();
        // populate the games list with data

        GameStoreAdapter adapter = new GameStoreAdapter(games, getContext());
        gameList.setAdapter(adapter);

        return view;
    }
}