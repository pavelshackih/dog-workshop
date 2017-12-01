package io.pavelshackih.dogappworkshop.domain.repository;

import java.util.List;

import io.pavelshackih.dogappworkshop.domain.Breed;
import io.reactivex.Single;

public interface RemoteRepository {

    Single<List<Breed>> getDogs();
}
