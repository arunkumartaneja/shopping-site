import Image from "next/image";
import Link from "next/link";

const CategoryList = async () => {
    //   const wixClient = await wixClientServer();

    //   const cats = await wixClient.collections.queryCollections().find();
    const cats: any[] = [1, 2, 3, 4];

    return (
        <div className="px-4 overflow-x-scroll scrollbar-hide">
            <div className="mt-12 flex gap-x-8 gap-y-16 justify-between flex-wrap">
                {cats.map((item) => (
                    <Link
                        href={`/list?cat=${item}`}
                        className="flex-shrink-0 w-full sm:w-1/2 lg:w-1/4 xl:w-1/6"
                        key={item}
                    >
                        <div className="relative bg-slate-100 w-full h-96">
                            <Image
                                src={"https://images.pexels.com/photos/1021693/pexels-photo-1021693.jpeg?auto=compress&cs=tinysrgb&w=800"}
                                alt=""
                                fill
                                sizes="20vw"
                                className="object-cover"
                            />
                        </div>
                        <h1 className="mt-8 font-light text-xl tracking-wide">
                            {item + '_name'}
                        </h1>
                    </Link>
                ))}
            </div>
        </div>
    );
};

export default CategoryList;