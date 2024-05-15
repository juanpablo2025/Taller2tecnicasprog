package repository;

import model.View;

import java.util.ArrayList;
import java.util.List;

public class ViewsRepositoryImpl implements ViewsRepository
{

    private final List<View> views;

    public ViewsRepositoryImpl()
    {

        this.views = new ArrayList<>();

    }

    @Override
    public View save(View view)
    {

        this.views.add( view );
        return view;

    }

    @Override
    public View add(View view) {
        this.views.add( view );
        return view;
    }
}