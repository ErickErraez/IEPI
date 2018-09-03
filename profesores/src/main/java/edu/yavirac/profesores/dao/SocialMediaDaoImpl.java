package edu.yavirac.profesores.dao;

import java.util.List;

import edu.yavirac.profesores.model.Courser;
import edu.yavirac.profesores.model.SocialMedia;
import edu.yavirac.profesores.model.Teacher;
import edu.yavirac.profesores.model.TeacherSocialMedia;

public class SocialMediaDaoImpl extends AbstaractSession implements SocialMediaDao {

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {

		getSession().persist(socialMedia);
	}

	@Override
	public void deleteSocialMediaById(Long idSocialMedia) {

		SocialMedia socialMedia = findById(idSocialMedia);
		if (socialMedia != null) {
			getSession().delete(socialMedia);
		}
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {

		getSession().update(socialMedia);
	}

	@Override
	public List<SocialMedia> finAllSocialMedia() {

		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findById(Long idSocialMedia) {

		return (SocialMedia) getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public SocialMedia findByName(String name) {

		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name").setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {

		List<Object[]> objects = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickname")
				.setParameter("idSocialMedia", idSocialMedia).setParameter("nickname", nickname).list();

		if (objects.size() > 0) {

			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					if (object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}

		return null;
	}

}
