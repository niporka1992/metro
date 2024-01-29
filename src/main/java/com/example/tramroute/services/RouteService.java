package com.example.tramroute.services;

import com.example.tramroute.entities.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    List<Route> getAllRoutes();

    Optional<Route> getRouteById(Long id);

    Long saveRoute(Route route);

    void deleteRoute(Long id);

    void updateRoute(Long id, Route updatedRoute);
}