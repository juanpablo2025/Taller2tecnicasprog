package repository;

import model.View;

public interface ViewsRepository {

    View save(View view);

    View add(View view);
}
