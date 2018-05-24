package mapper; //importʡ��

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Cart;
import entity.User;
import entity.UserGoods;

@Repository
public interface IUserMapper {
	@Insert("insert into user(username,password) values(#{username},#{password})")
	public int addUser(User user);

	@Delete("delete from user where id=#{id}")
	public int deleteUser(int id);

	@Update("update user set username=#{username},password=#{password} where id=#{id}")
	public int updateUser(User user);

	@Select("select * from user where id=#{id}")
	public User getUserById(int id);

	@Select("select * from user where username=#{username} and password=#{password} ")
	public User findUser(User user);

	@Select("select * from user where username=#{username}")
	public User findUserByUserName(String username);

	@Select("select * from user")
	public List<User> getAllUsers();
	
	@Select("select * from dingdan,user,goods where user.id=dingdan.uid and goods.idd=dingdan.gid order by xiadan_time desc")
	public List<UserGoods> getUserGoods();
	
	@Select("select * from cart where uid=#{u} and state=#{s}")
	public List<Cart> getCart(@Param("u") int uid, @Param("s") int state);
	
	@Select("select * from cart where id=#{u}")
	public Cart getCart1(@Param("u") int id);
	
	@Delete("delete from cart where id=#{id}")
	public int deleteCart(@Param("id") int id);
	
	@Select("select * from dingdan,user,goods where user.id=dingdan.uid and goods.idd=dingdan.gid and dingdanhao=#{m}")
	public List<UserGoods> getCartGoods(@Param("m") int m);
	
	@Select("select COALESCE(sum(total),0) from dingdan where dingdanhao=#{m}")
	public double getTotals(@Param("m") int m);
	
	@Update("update user set username=#{username},address=#{address},phone=#{phone} where id=#{id}")
	public int updateUsers(User user);
	
	@Delete("delete from dingdan where dingdanhao=#{id}")
	public int delete(@Param("id") int id);
	
	@Update("update dingdan set state=#{s},fukuan_time=#{f} where dingdanhao=#{d}")
	public int Pay(@Param("s") String s, @Param("f") Timestamp t, @Param("d") int id);
	
	@Update("update dingdan set state=#{s},shouhuo_time=#{f} where dingdanhao=#{d}")
	public int Shouhuo(@Param("s") String s, @Param("f") Timestamp t, @Param("d") int id);
	
	
}