package com.skillswap.service;

import com.skillswap.dto.UserDTO;
import com.skillswap.exception.ResourceNotFoundException;
import com.skillswap.model.User;
import com.skillswap.repository.RatingRepository;
import com.skillswap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingRepository ratingRepository;

    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        return convertToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getBio() != null) {
            user.setBio(userDTO.getBio());
        }

        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    private UserDTO convertToDTO(User user) {
        List<Integer> ratings = ratingRepository.findByRateeId(user.getId())
                .stream()
                .map(rating -> rating.getRating())
                .collect(Collectors.toList());

        Double averageRating = ratings.isEmpty() ? 0.0 :
                ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .bio(user.getBio())
                .averageRating(averageRating)
                .totalReviews(ratings.size())
                .build();
    }
}
