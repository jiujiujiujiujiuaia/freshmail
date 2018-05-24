package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import entity.Admin;
import entity.Goods;
import entity.UserGoods;

@Repository
public interface IAdminMapper {
	@Select("select * from admin where adminname=#{adminname} and password=#{password}")
	public Admin findAdmin(Admin admin);
	
	@Select("select * from goods order by idd desc")
	public List<Goods> getGoods();
	
	@Insert("insert into goods values(null,#{goodsname},#{describe},#{type},#{price},#{picture})")
	public int addGoods(Goods goods);
	
	@Update("update goods set goodsname=#{goodsname},type=#{type},price=#{price},picture=#{picture} where idd=#{idd}")
	public int editGoods(Goods goods);
	
	@Update("update goods set goodsname=#{goodsname},type=#{type},price=#{price} where idd=#{idd}")
	public int editGoods1(Goods goods);
	
	@Select("select * from dingdan,user,goods where dingdan.uid=user.id and dingdan.gid=goods.idd  order by xiadan_time desc")
	public List<UserGoods> getUserGoods();
	
	@Select("select * from dingdan,user,goods where user.id=dingdan.uid and goods.idd=dingdan.gid and dingdanhao=#{m}")
	public List<UserGoods> getCartGoods(@Param("m") int m);
	
	@Select("select COALESCE(sum(total),0) from dingdan where dingdanhao=#{m}")
	public double getTotals(@Param("m") int m);
	
	@Update("update dingdan set state=#{s} where dingdanhao=#{d}")
	public int Fahuo(@Param("s") String s, @Param("d") int d);
	
	@Delete("delete  from goods where idd=#{i}")
	public int delete(@Param("i") int i);
}
