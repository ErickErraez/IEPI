package edu.yavirac.profesores.services;

import java.util.List;

import edu.yavirac.profesores.model.SocialMedia;
import edu.yavirac.profesores.model.TeacherSocialMedia;

public interface SocialMediaService {
	void saveSocialMedia(SocialMedia socialMedia);

	void deleteSocialMediaById(Long idSocialMedia);

	void updateSocialMedia(SocialMedia socialMedia);

	List<SocialMedia> finAllSocialMedia();

	SocialMedia findById(Long idSocialMedia);

	SocialMedia findByName(String name);

	TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname);

}
