package bupt.zssdhl.SSHFrame.DaoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Dao.FileInfoDao;

@Transactional
public class FileInfoDaoImpl implements FileInfoDao{
	
	private SessionFactory sessionFactory;
	private static Log _log = LogFactory.getLog(FileInfoDaoImpl.class);
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addFileInfo(FileInfo fileInfo) {
		
		sessionFactory.getCurrentSession().save(fileInfo);
		
	}
	
	@Override
	public void delFileInfo(FileInfo fileInfo) {
		
		sessionFactory.getCurrentSession().delete(fileInfo);
	}
	
	@Override
	public void updateFileInfo(FileInfo fileInfo) {
		
		sessionFactory.getCurrentSession().update(fileInfo);
	}
	
	@Override
	public FileInfo findFileInfosById(Integer id) {
		return (FileInfo) sessionFactory.getCurrentSession().get(FileInfo.class, id);
	}
	
	@Override
	public FileInfo findeFileInfosByMD5(String MD5) {
		
		FileInfo fileInfo = null;
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from FileInfo where MD5 =:MD5");
		query.setParameter("MD5", MD5);
		List<FileInfo> fileInfos = query.list();
		
		if(0 != fileInfos.size()){
			fileInfo = fileInfos.get(0);
			_log.info("there exit same file");
		}else{
			_log.info("there is no such file");
		}
		return fileInfo;
	}
	
	@Override
	public List<FileInfo> findFileInfosByUserId(Integer id, int firstResult,
			int maxResult) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("from FileInfo where UserInfo_id =:userid order by id");
		query.setParameter("userid", id);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		List<FileInfo> list = query.list();
		return list;
		  
		
	}
	@Override
	public int getFileCountByUserId(Integer id) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("select count(*) from FileInfo where UserInfo_id =:userid");
		query.setParameter("userid", id);
		return Integer.valueOf(((Long)query.uniqueResult()).toString());
	}
	
	@Override
	//0:public 1:private
	public List<FileInfo> findPublicFileInfos(int firstResult, int maxResult) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from FileInfo where grade =:grade order by id");
		query.setParameter("grade", 0);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return  query.list();
	}
	@Override
	public int getPublicFileCount() {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("select count(*) from FileInfo where grade =:grade");
		query.setParameter("grade", 0);
		return Integer.valueOf(((Long)query.uniqueResult()).toString());
	}
	
	@Override
	public List<FileInfo> findAllFileInfos(int firstResult, int maxResult) {
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from FileInfo order by id");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	@Override
	public int getAllFileCount() {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("select count(*) from FileInfo");
		return Integer.valueOf(((Long)query.uniqueResult()).toString());
	}
	
	
}
