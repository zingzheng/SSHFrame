package bupt.zssdhl.SSHFrame.DaoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import bupt.zssdhl.SSHFrame.Bean.FilePhy;
import bupt.zssdhl.SSHFrame.Dao.FilePhyDao;


@Transactional
public class FilePhyDaoImpl implements FilePhyDao{
	private FilePhy filePhy;
	private SessionFactory sessionFactory;
	private static Log _log = LogFactory.getLog(FilePhyDaoImpl.class);

	public FilePhy getFilePhy() {
		return filePhy;
	}
	public void setFilePhy(FilePhy filePhy) {
		this.filePhy = filePhy;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 根据MD5值获取物理文件信息
	 */
	@Override
	public FilePhy getFilePhyByMD5(String MD5) {
		FilePhy filePhy = null;
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from FilePhy where MD5 =:MD5");
		query.setParameter("MD5", MD5);
		List<FilePhy> filePhys = query.list();
		
		if(0 != filePhys.size()){
			filePhy = filePhys.get(0);
			_log.info("there exit same file");
		}else{
			_log.info("there is no such file");
		}
		return filePhy;
	}
	@Override
	public void addFilePhy(FilePhy filePhy) {
		
		sessionFactory.getCurrentSession().save(filePhy);
	}
	
}
