package reto2.reto2.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import reto2.reto2.models.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {
    public abstract ArrayList<UserModel> findByEmail(String email);
    Optional <UserModel> findByEmailAndPassword(String email, String password);
}
