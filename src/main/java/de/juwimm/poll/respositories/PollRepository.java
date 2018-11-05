package de.juwimm.poll.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.juwimm.poll.model.Poll;

@Repository
@Transactional
public interface PollRepository extends JpaRepository<Poll, Integer> {
	
	@Query("SELECT p FROM Poll p WHERE UPPER(p.name) = :name AND UPPER(p.site) = :site")
	public Poll findByNameAndSite(@Param("name") String name, @Param("site") String site);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Poll p set p.xmldata =:xmldata WHERE p.id =:id")
	public void updateById(@Param("id") Integer id, @Param("xmldata") String xmldata);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Poll p set p.xmldata =:xmldata WHERE UPPER(p.name) = :name AND UPPER(p.site) = :site")
	public void updateBySiteAndName(@Param("name") String name, @Param("site") String site, @Param("xmldata") String xmldata);

}
