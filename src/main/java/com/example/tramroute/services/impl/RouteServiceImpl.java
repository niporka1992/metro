package com.example.tramroute.services.impl;

import com.example.tramroute.entities.Route;
import com.example.tramroute.repositories.RouteRepository;
import com.example.tramroute.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    @Override
    public Long saveRoute(Route route) {
        Route savedRoute = routeRepository.save(route);
        return savedRoute.getId();
    }

    @Override
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public void updateRoute(Long id, Route updatedRoute) {
        Optional<Route> existingRouteOptional = routeRepository.findById(id);
        existingRouteOptional.ifPresent(existingRoute -> {
            existingRoute.setCode(updatedRoute.getCode());
            existingRoute.setName(updatedRoute.getName());
            routeRepository.save(existingRoute);
        });
    }
}